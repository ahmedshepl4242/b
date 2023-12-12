package com.example.Paint.Services;


import com.example.Paint.Shapes.Shape;

import java.util.Stack;

public class UndoRedo implements IUndoRedo {


    Stack<Action> PreviousActions = new Stack<>();
    Stack<Action> Redo = new Stack<>();


    @Override
    public Action undo() {
        if (PreviousActions.isEmpty()) {
            return null;
        }

        Action action = PreviousActions.pop();

        if (action.getType().equalsIgnoreCase("delete")) {
            UndoDelete(new Action(action));


        } else if (action.getType().equalsIgnoreCase("create")) {
            Undocreate(new Action(action));


        } else if (action.getType().equalsIgnoreCase("ShapeAttributes")) {
            action.setType("ShapeAttributes");
            UndoChangeAtrributes(action);

        }


        return action;
    }

    public Action redo() {


        if (Redo.isEmpty()) {
            System.out.println("stack is empty");
            return null;
        }
        Action action = Redo.pop();

        if (action.getType().equalsIgnoreCase("delete")) {

            RedoDelete(new Action(action));



        } else if (action.getType().equalsIgnoreCase("create")) {
            Redocreate(new Action(action));



            System.out.println(action.getType());


        } else if (action.getType().equalsIgnoreCase("ShapeAttributes")) {
            action.setType("ShapeAttributes");
            RedoChangeAtrributes(action);

        }

        return action;

    }


    public void storeAction(Action act) {


        while (!Redo.isEmpty()) {
            Redo.pop();
        }
        PreviousActions.push(act);
    }
    public void refresh(){
        Redo.clear();
        PreviousActions.clear();
    }


    @Override
    public void UndoDelete(Action act) {


        act.setType("create");
        Redo.push(act);

        MyService.mp.put(act.getId(), MyService.factry.CreateShape(act.getShape().getType(), act.getShape().getX(), act.getShape().getY(), act.getShape().getRotationangle(), act.getShape().getXscale(), act.getShape().getYscale(), act.getShape().getFillcolor(), act.getShape().getId(), act.getShape().getType(), act.getShape().getMorefeatures()));

    }

    @Override
    public void Undocreate(Action act) {

//        System.out.println("ccccccccccccccc");


        act.setType("delete");
        act.setShape((Shape) MyService.mp.get(act.id));


        System.out.println(act.type);


        Redo.push(act);


        MyService.mp.remove(act.getId());
    }


    @Override
    public void UndoChangeAtrributes(Action act) {


        Action ac = new Action();

        ac.setShape((Shape) MyService.mp.get(act.getId()));
        ac.setType("ShapeAttributes");
        ac.setId(act.getId());


        Redo.push(ac);

        MyService.mp.put(act.getId(), act.getShape());
    }


    @Override
    public void RedoDelete(Action act) {


        act.setType("create");

        PreviousActions.push(act);

        MyService.mp.put(act.getId(), MyService.factry.CreateShape(act.getShape().getType(), act.getShape().getX(), act.getShape().getY(), act.getShape().getRotationangle(), act.getShape().getXscale(), act.getShape().getYscale(), act.getShape().getFillcolor(), act.getShape().getId(), act.getShape().getType(), act.getShape().getMorefeatures()));
//        System.out.println("wwwwwwwwwww");
    }

    @Override
    public void Redocreate(Action act) {


        act.setType("delete");
        PreviousActions.push(act);


        System.out.println(act.getId() + "      fddfdf");
        MyService.mp.remove(act.getId());
    }


    @Override
    public void RedoChangeAtrributes(Action act) {

        Action ac = new Action();
        ac.setShape((Shape) MyService.mp.get(act.getId()));
        ac.setType("ShapeAttributes");
        ac.setId(act.getId());

        PreviousActions.push(ac);


        MyService.mp.put(act.getId(), act.getShape());
    }


    @Override
    public void UndoColorize() {
//        Action act;
//        if (!PreviousActions.isEmpty()) {
//            act = PreviousActions.pop();
//            if (Redo == null) {
//                Redo = new Stack<>();
//            }
//            Redo.push(act);
//        }
    }
}
