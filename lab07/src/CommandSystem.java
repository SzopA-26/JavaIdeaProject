import java.util.ArrayList;

public class CommandSystem {
    private ArrayList<MyFile> files = new ArrayList<>();
    private String command;
    private String params;
    private String output;

    public void execute(String command) {
        if (command.contains(" ")) {
            this.command = command.substring(0, command.indexOf(" "));
            this.params = command.substring(command.indexOf(" ") + 1);
        } else {
            this.command = command;
            this.params = "";
        }
        switch (this.command) {
            case "touch":
                if (getFileIndex(params) != -1) {
                    output = "File " + params + " Already Exist";
                } else {
                    output = null;
                    files.add(new MyFile(params));
                }
                break;
            case "cat":
                if (getFileIndex(params) == -1) {
                    output = "File " + params + " Not Found";
                } else {
                    output = files.get(getFileIndex(params)).getContent();
                }
                break;
            case "echo":
                String content = "";
                String fileName = "";
                if (params.contains("\"")) {
                    content = params.substring(1, params.lastIndexOf("\""));
                    if (params.contains(">>")) {
                        fileName = params.substring(params.indexOf(">>") + 3);
                    } else if (params.contains(">")) {
                        fileName = params.substring(params.indexOf(">") + 2);
                    }
                } else {
                    if (params.contains(">>")) {
                        content = params.substring(0, params.indexOf(">>") - 1);
                        fileName = params.substring(params.indexOf(">>") + 3);
                    } else if (params.contains(">")) {
                        content = params.substring(0, params.indexOf(">") - 1);
                        fileName = params.substring(params.indexOf(">") + 2);
                    }
                }
                if (getFileIndex(fileName) == -1) {
                    output = "File " + fileName + " Not Found";
                } else {
                    output = null;
                    if (params.contains(">>")) {
                        files.get(getFileIndex(fileName)).appendContent(content);
                    } else if (params.contains(">")) {
                        files.get(getFileIndex(fileName)).setContent(content);
                    }
                }
                break;
            case "exit":
                output = null;
                break;
        }
    }

    public String getCommand() {
        return command;
    }

    public String getParams() {
        return params;
    }

    public String getOutput() {
        return output;
    }

    public int getFileIndex(String name) {
        int i;
        for (i = 0; i < files.size(); i++) {
            if (files.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
