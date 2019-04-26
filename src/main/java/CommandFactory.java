import org.apache.log4j.Logger;
import java.util.HashMap;


public class CommandFactory {

    final static Logger log = Logger.getLogger(CommandFactory.class.getName());

    private static CommandFactory cf;

    private HashMap<String, Command> cache;

    public CommandFactory(){
        this.cache = new HashMap<String, Command>();
    }

    public static CommandFactory getInstance(){
        if ( cf == null) {
            cf = new CommandFactory();
        }
            return cf;

    }

    public Command getCommand(String id){
        Command command = this.cache.get(id);
        if (command == null){
            command = getCommandnew(id);
            this.cache.put(id, command);
        }
        return command;
    }

    public Command getCommandnew(String name){

        Command command = null;
        Class a = null;

        try {
            a = Class.forName(name);
            command = (Command) a.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        return command;
    }
}
