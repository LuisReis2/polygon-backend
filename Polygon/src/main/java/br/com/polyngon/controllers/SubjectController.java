package br.com.polyngon.controllers;


import br.com.polyngon.entity.Subject;
import br.com.polyngon.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Facilita a geraçao  de response body e controller, pois já deixa implicito
@RequestMapping("/subjects") // Mapeia essa requisição, para o controller gerenciar
public class SubjectController {

    // TODO: Aprender melhor
    @Autowired //Já entende que o Subject controller necessita do SubjectsRepository e já gera a instancia

    SubjectRepository subjectRepository;

    @GetMapping
    public List getAllSubjects(){
        return subjectRepository.findAll();
    }

    @GetMapping("{/id}")
   public ResponseEntity<Subject> getSubjectById(@PathVariable("id") Long id){

        Subject subject = subjectRepository.findById(id).orElse(null);

        if (subject == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject){
        Subject savedSubject = subjectRepository.save(subject);
        return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable("id") Long id){

        Subject subject = subjectRepository.findById(id).orElse(null);

        if(subject == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        subjectRepository.delete(subject);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable("id") Long id, @RequestBody Subject subject){

        try{
            Subject currentSubject = subjectRepository.findById(id).orElse(null);

            if(currentSubject == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            currentSubject.setName(subject.getName());
            currentSubject.setIcon(subject.getIcon());
            currentSubject.setQtd_articles(subject.getQtd_articles());


            Subject updateSubject = subjectRepository.save(currentSubject);

            return new ResponseEntity<>(updateSubject, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }
}
