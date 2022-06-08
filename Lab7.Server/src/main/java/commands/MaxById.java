package commands;

import app.CollectionManager;
import app.UserManager;
import collections.User;
import collections.Vehicle;
import data.Request;
import data.Response;
import java.util.Scanner;
/**
 * Команда MaxById
 */
public class MaxById implements ICommand{

    private final CollectionManager collectionManager;

    public MaxById(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request) {
        User user = UserManager.getInstance().get(request.getLogin(), request.getHash());
        if (user == null) {
            return new Response(request.getCommand(), null, "To execute commands login first!\n\n");
        }
        
        Vehicle vehicle = collectionManager.getMaxById();
        String output = "=========== Executing command (MaxById) =============\n"
                + ((vehicle!=null)?vehicle.toString():"Collection is empty!")
                + "\n============ Operation success (MaxById) ============\n\n";
        return new Response(request.getCommand(), null, output);
    }

    @Override
    public String toString() {
        return "max_by_id - Display any object from the collection whose id field value is the maximum";
    }

}

