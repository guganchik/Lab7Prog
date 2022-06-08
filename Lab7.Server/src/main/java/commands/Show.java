package commands;

import app.CollectionManager;
import app.DataProvider;
import app.UserManager;
import collections.User;
import collections.Vehicle;
import data.Request;
import data.Response;
import java.util.Comparator;
import java.util.Scanner;
/**
 * Команда Show
 */
public class Show implements ICommand {
    private final CollectionManager collectionManager;

    public Show(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    
    @Override
    public Response execute(Request request) {
        User user = UserManager.getInstance().get(request.getLogin(), request.getHash());
        if (user == null) {
            return new Response(request.getCommand(), null, "To execute commands login first!\n\n");
        }
        
        String output =  "============= Executing command (Show) ==============\n"
                + collectionManager.show()
                + "============= Operation success (Show) ==============\n\n";
        return new Response(request.getCommand(), null, output);
    }
        
    @Override
    public String toString() {
        return "show - Print to standard output all elements of the collection in string representation";
    }
}
