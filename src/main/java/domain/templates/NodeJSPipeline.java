package domain.templates;

import domain.Project;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class NodeJSPipeline extends PipelineTemplate {
    private static final Logger logger = LogManager.getLogger(NodeJSPipeline.class);
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
        logger.info("Run npm install");
        logger.info("installing nodejs");
        logger.info("------------------------");
//        if(true){
            this.failed("NPM Install failed!");
//        }
    }
    private void copyPath(){
        logger.info("Copying files to " + path);
        logger.info("------------------------");
    }
}
