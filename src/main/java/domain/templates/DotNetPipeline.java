package domain.templates;

import domain.Project;

public class DotNetPipeline extends PipelineTemplate {
    private boolean restore;
    public DotNetPipeline(Project project, String link,String name, boolean restore) {
        super(project, link, name);
        this.restore = restore;
    }

    @Override
    public void run() {
        NewGetInstall();
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
    private void NewGetInstall(){
        logger.info("Using NuGet installer");
    }
}
