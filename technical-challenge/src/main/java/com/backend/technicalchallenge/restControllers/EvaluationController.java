package com.backend.technicalchallenge.restControllers;


import com.backend.technicalchallenge.model.evaluation.Evaluation;
import com.backend.technicalchallenge.model.questionnaire.GroupApp;
import com.backend.technicalchallenge.model.questionnaire.Question;
import com.backend.technicalchallenge.services.interfaces.EvaluationService;
import com.backend.technicalchallenge.services.interfaces.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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


    @GetMapping("/gteEvaluations")
    public ResponseEntity<Object> getEvaluations(){
        List<Evaluation> evaluations = evaluationService.getEvaluations();
        if(!evaluations.isEmpty()){
            return new ResponseEntity<>(evaluations, new HttpHeaders(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There's no evaluations on database", new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PostMapping("/persistEvaluation")
    public ResponseEntity<Object> persistEvaluation(Evaluation evaluation){
            evaluationService.saveEvaluation(evaluation);
            List<Evaluation> savedEvaluations = evaluationService.getEvaluations();
        if(!savedEvaluations.isEmpty()){
            return new ResponseEntity<>(savedEvaluations, new HttpHeaders(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There's no evaluation saved on database", new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
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
