package domain.templates;

import domain.Project;

public class NodeJSPipeline extends PipelineTemplate {
    private String path;
    private boolean pathIncl;
    public NodeJSPipeline(Project project, String link,String name, String path) {
        super(project, link, name);
        this.path = path;
    }
    

    @Override
    public void run() {
        super.run();
        copyPath();
    }
    @Override
    public void build(){
        System.out.println("Run npm install");
        System.out.println("installing nodejs");
        System.out.println("------------------------");
//        if(true){
            this.failed("NPM Install failed!");
//        }
    }
    public void copyPath(){
        System.out.println("Copying files to " + path);
        System.out.println("------------------------");
    }
}
