package domain.templates;

import domain.Project;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DotNetPipeline extends PipelineTemplate {
    private static final Logger logger = LogManager.getLogger(DotNetPipeline.class);
    private boolean restore;
    public DotNetPipeline(Project project, String link,String name, boolean restore) {
        super(project, link, name);
        this.restore = restore;
    }

    @Override
    public void run() {
        NGInstall();
        if(restore){
            restore();
        }

        super.run();

    }
    @Override
    public void build(){
        logger.info("Building project.sln");
        logger.info("installing dir");

    }
    private void restore(){
        logger.info("Using NuGet restore");

    }
    private void NGInstall(){
        logger.info("Using NuGet installer");
    }
}
