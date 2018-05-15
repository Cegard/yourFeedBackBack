package com.backend.technicalchallenge.restControllers;


import com.backend.technicalchallenge.model.Status;
import com.backend.technicalchallenge.model.Type;
import com.backend.technicalchallenge.model.evaluation.EvaluatedUser;
import com.backend.technicalchallenge.model.evaluation.Evaluation;
import com.backend.technicalchallenge.model.evaluation.GroupComment;
import com.backend.technicalchallenge.model.event.Event;
import com.backend.technicalchallenge.model.questionnaire.Answer;
import com.backend.technicalchallenge.model.questionnaire.GroupApp;
import com.backend.technicalchallenge.model.questionnaire.Question;
import com.backend.technicalchallenge.model.user.UserApp;
import com.backend.technicalchallenge.persistance.*;
import com.backend.technicalchallenge.services.interfaces.EvaluationService;
import com.backend.technicalchallenge.services.interfaces.EventService;
import com.backend.technicalchallenge.services.interfaces.QuestionnaireService;
import com.backend.technicalchallenge.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private GroupCommentRepository groupCommentRepository;

    @Autowired
    private GroupAppRepository groupAppRepository;


    @GetMapping("/getEvaluations")
    public ResponseEntity<Object> getEvaluations(){
        List<Evaluation> evaluations = evaluationService.getEvaluations();
        if(!evaluations.isEmpty()){
            return new ResponseEntity<>(evaluations, new HttpHeaders(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There's no evaluations on database", new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PostMapping("/persistEvaluation")
    public ResponseEntity<Object> persistEvaluation(@RequestParam(name = "idEvent") Long idEvent,
                                                    @RequestParam(name = "idEvaluator")Long idEvaluator,
                                                    @RequestParam(name ="idEvaluatedUser") Long idEvaluatedUser,
                                                    @RequestParam(name ="note") String note,
                                                    @RequestBody List<Answer> answers){

        Long evaluationId = evaluationService.persistEvaluation(idEvent, idEvaluator, idEvaluatedUser, note, answers);

        if(evaluationId != null){

            ResponseEntity<Object> result =  evaluationService.getEvaluation(evaluationId)!=null? new ResponseEntity<>(evaluationId, new HttpHeaders(), HttpStatus.OK): new ResponseEntity<>("couldn't be saved on database", new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);;
            return result;

        }else{
            return new ResponseEntity<>("Some of the id's isn't a valid one", new HttpHeaders(), HttpStatus.CONFLICT);
        }

    }

    @PostMapping("/persistEvaluationGroupComments")
    public ResponseEntity<Object> persistEvaluation(@RequestParam(name = "idEvaluation") Long idEvaluation,
                                                    @RequestBody List<GroupComment> groupComments){

        Optional<Evaluation> evaluation = evaluationService.getEvaluation(idEvaluation);

        if(evaluation.isPresent()){

            groupComments.forEach(groupComment -> {
                groupComment.setStatus(Status.ACTIVE);
                groupComment.setEvaluation(evaluation.get());
                groupComment.setGroupApp(groupAppRepository.findById(groupComment.getGroupApp().getId()).get());
                groupCommentRepository.save(groupComment);
            });

            ResponseEntity<Object> result =  evaluationService.getEvaluation(evaluation.get().getId())!=null? new ResponseEntity<>(evaluation, new HttpHeaders(), HttpStatus.OK): new ResponseEntity<>("couldn't be saved on database", new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);;
            return result;

        }else{
            return new ResponseEntity<>("Some of the id's isn't a valid one", new HttpHeaders(), HttpStatus.CONFLICT);
        }

    }


    @GetMapping("/getQuestionsGroups/{id}")
    public List<GroupApp> getGroups(@PathVariable("id") Long idEvent){
         return questionnaireService.getGroupAppOfEventQuestionnaire(idEvent);
    }
    @GetMapping("/getQuestions/{idEvent}/{idGroup}")
    public List<Question> getQuestionsByEvent(@PathVariable("idEvent") Long idEvent,@PathVariable("idGroup") Long idGroup){
        return questionnaireService.getQuestionsOfGroup(idEvent, idGroup);
    }




}
