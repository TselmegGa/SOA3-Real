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
        NGInstall();
        if(restore){
            restore();
        }

        super.run();

    }
    @Override
    public void build(){
        System.out.println("Building project.sln");
        System.out.println("installing dir");
        System.out.println("------------------------");
    }
    public void restore(){
        System.out.println("Using NuGet restore");
        System.out.println("------------------------");
    }
    public void NGInstall(){
        System.out.println("Using NuGet installer");
        System.out.println("------------------------");
    }
}
