package com.example.Paint.Controller;

import com.example.Paint.Services.Action;
import com.example.Paint.Services.LoadSave.Xmlbody;
import com.example.Paint.Services.MyService;
import com.example.Paint.Services.copyid;
import com.example.Paint.Services.uuid;

import com.example.Paint.Shapes.Shape;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

import java.util.List;
@CrossOrigin("https://paint-app-frontend-self.vercel.app/")
@RestController
@RequestMapping("/api")
public class Controller {
    MyService myService = new MyService();

    @GetMapping(value = "/get", produces = "application/json")


    List<String>  getAction() {
        return myService.getData();
    }


    @PostMapping("/create")
    String CreateShape(@RequestBody Shape shape) {
        System.out.println(shape.getType());
        String s = this.myService.CreateShape(shape);
        return s;
    }

    @PostMapping("/copy")
    String copy(@RequestBody copyid ID) {

        System.out.println(ID.getNewID());
        System.out.println(ID.getOldID());

        this.myService.copy(ID);
        return "ggggg";
    }

    @PutMapping("/update")
    void update(@RequestBody Shape shape) {
        this.myService.updateShape(shape);
    }

    @PutMapping("/undo")
    Action undo() {
        this.myService.undo();
        return myService.getAction();
    }

    @PutMapping("/redo")
    Action redo() {
        this.myService.redo();
        return myService.getAction();


    }

    @DeleteMapping("/refresh")
    void refresh(){
        this.myService.refresh();

    }

    @DeleteMapping("/delete")
    void DeleteShape(@RequestBody uuid id) {
        System.out.println(id.getId());
        this.myService.DeleteShape(id);


    }


    @GetMapping("/savexml")
    String saveXml() throws JsonProcessingException {
       return myService.savexml();
    }
    @GetMapping("/savejson")
    String saveJson() throws JsonProcessingException {
         return myService.savejson();
    }
    @PostMapping("/loadxml")
    List<Shape>  LoadXml(@RequestBody Xmlbody name) throws IOException {
        System.out.println(name.getXml());
        return  myService.loadxml(name.getXml());
    }
    @PostMapping("/loadjson")
    public List<Shape> Loadjson(@RequestBody  String name ) throws IOException {

        System.out.println(name);
        return  myService.loadjson(name);
    }



}
