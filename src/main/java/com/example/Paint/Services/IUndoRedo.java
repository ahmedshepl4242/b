package com.example.Paint.Services;

public interface IUndoRedo {



    public void UndoDelete(Action act);
    public void refresh();



    public void storeAction(Action act);


    public void Undocreate(Action act)
            ;

    public void UndoColorize()
            ;

    public void UndoChangeAtrributes(Action act)
            ;

    void RedoDelete(Action act);

    void Redocreate(Action act);

    void RedoChangeAtrributes(Action act);

    Action undo();

    Action redo();
}
