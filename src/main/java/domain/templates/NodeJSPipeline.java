package domain.templates;

import domain.Project;
public class NodeJSPipeline extends PipelineTemplate {

    private String path;

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
        logger.info("Run npm install");
        logger.info("installing nodejs");

        this.failed("NPM Install failed!");

    }
    private void copyPath(){
        logger.info("Copying files to " + path);

    }
}
