package com.backend.technicalchallenge.services.Implementations;

import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.Type;
import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.evaluation.Evaluation;
import com.backend.technicalchallenge.model.evaluation.GroupComment;
import com.backend.technicalchallenge.model.event.Event;
import com.backend.technicalchallenge.model.questionnaire.Answer;
import com.backend.technicalchallenge.model.user.UserApp;
import com.backend.technicalchallenge.persistance.*;
import com.backend.technicalchallenge.services.interfaces.EvaluationService;
import com.backend.technicalchallenge.services.interfaces.EventService;
import com.backend.technicalchallenge.services.interfaces.QuestionnaireService;
import com.backend.technicalchallenge.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private GroupAppRepository groupAppRepository;

    @Autowired
    private GroupCommentRepository groupCommentRepository;

    @Autowired
    private EvaluatedUserRepository evaluatedUserRepository;


    @Override
    public boolean saveEvaluation(Evaluation evaluation) {
        evaluationRepository.save(evaluation);
        return true;
    }

    @Override
    public List<Evaluation> getEvaluations() {
        return evaluationRepository.findAll();
    }

    @Override
    public Optional<Evaluation> getEvaluationById(Long idEvaluation) {
        return evaluationRepository.findById(idEvaluation);
    }

    @Override
    public Optional<Evaluation> getEvaluation(Long idEvaluation) {
        return evaluationRepository.findById(idEvaluation);
    }

    @Override
    public Long persistEvaluation(Long idEvent, Long idEvaluator, Long idEvaluatedUser, String note, List<Answer> answers){

        Evaluation evaluation = new Evaluation();
        Optional<Event> event = eventService.getEventId(idEvent);
        Optional<UserApp> evaluator = userService.getUserById(idEvaluator);
        Optional<EvaluatedUser> evaluatedUser = userService.getEvaluatedUserById(idEvaluatedUser);


        if(event.isPresent() && evaluatedUser.isPresent() && evaluatedUser.isPresent() ){

            evaluation.setEvent(event.get());
            evaluation.setDate(new Date());
            evaluation.setStatus(Status.ACTIVE);
            evaluation.setUserEvaluator(evaluator.get());
            evaluation.setEvaluatedUser(evaluatedUser.get());
            evaluation.setNote(note);
            evaluation.setType(Type.USER);
            saveEvaluation(evaluation);
            evaluation = getEvaluation(evaluation.getId()).get();
            Evaluation finalEvaluation = evaluation;
            answers.forEach(answer -> {
                answer.setStatus(Status.ACTIVE);
                answer.setQuestion(questionnaireService.getQuestionById(answer.getQuestion().getId()).get());
                answer.setEvaluation(finalEvaluation);
                answerRepository.save(answer);
            });

            return finalEvaluation.getId();
        }else {
            return null;
        }
    }

    @Override
    public boolean persistEvaluationGroupComments(Long idEvaluation, List<GroupComment> groupComments) {

        Optional<Evaluation> evaluation = getEvaluation(idEvaluation);

        if (evaluation.isPresent()) {

            groupComments.forEach(groupComment -> {
                groupComment.setStatus(Status.ACTIVE);
                groupComment.setEvaluation(evaluation.get());
                groupComment.setGroupApp(groupAppRepository.findById(groupComment.getGroupApp().getId()).get());
                groupCommentRepository.save(groupComment);
            });

            return true;

        } else {
            return false;
        }
    }

    @Override
    public List<Object> getScore(Long idEvaluation) {

        return  answerRepository.getScore(idEvaluation);
    }

    @Override
    public List<EvaluatedUser> getEvaluatedUserByUserApp(Long idUser) {
        Optional<UserApp> userApp = userService.getUserById(idUser);
        return evaluatedUserRepository.findByUserApp(userApp);
    }

    @Override
    public List<Object> getAverage(Long idEvaluation) {
        return answerRepository.getAverage(idEvaluation);
    }

}
