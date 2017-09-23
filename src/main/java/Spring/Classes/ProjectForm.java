package Spring.Classes;

import javax.validation.constraints.NotNull;

public class ProjectForm {
	
	@NotNull
    private String path;

    @NotNull
    private String cmd;

    public String getpath() {
        return this.path;
    }

    public void setpath(String path) {
        this.path = path;
    }

    public String getcmd() {
        return cmd;
    }

    public void setcmd(String cmd) {
        this.cmd = cmd;
    }

    public String toString() {
        return "Person(Name: " + this.path + ", Age: " + this.cmd + ")";
    }

}
