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
import com.backend.technicalchallenge.persistance.EvaluatedUserRepository;
import com.backend.technicalchallenge.persistance.EventRepository;
import com.backend.technicalchallenge.persistance.UserRepository;
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
    public ResponseEntity<Object> persistEvaluation(@RequestBody Evaluation evaluation){

        Optional<Event> event = eventService.getEventId(evaluation.getEvent().getId());
        Optional<UserApp> evaluator = userService.getUserById(evaluation.getUserEvaluator().getId());
        Optional<EvaluatedUser> evaluatedUser = userService.getEvaluatedUserById(evaluation.getEvaluatedUser().getId());


        if(event.isPresent() && evaluatedUser.isPresent() && evaluatedUser.isPresent() ){
            System.out.println("here");
            evaluation.setEvent(event.get());
            System.out.println("here");
            evaluation.setDate(new Date());
            evaluation.setStatus(Status.ACTIVE);
            System.out.println("here");
            evaluation.setUserEvaluator(evaluator.get());
            System.out.println("here");
            evaluation.setEvaluatedUser(evaluatedUser.get());
            System.out.println("here");
            evaluation.setType(Type.USER);
            System.out.println("here");
            System.out.println(evaluation.toString());
            evaluation.getAnswers().forEach(answer -> {
                System.out.println("here");
                answer.setQuestion(questionnaireService.getQuestionById(answer.getQuestion().getId()).get());

                answer.setStatus(Status.ACTIVE);
            });
            System.out.println("here");
            System.out.println(evaluation.toString());

            evaluationService.saveEvaluation(evaluation);
            System.out.println("here");
            ResponseEntity<Object> result = evaluationService.getEvaluations()!=null? new ResponseEntity<>(evaluation, new HttpHeaders(), HttpStatus.OK): new ResponseEntity<>("couldn't be saved on database", new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);;
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
