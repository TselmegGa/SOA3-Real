package Domain.Templates;

import Domain.Project;

public class AndroidPipeline extends PipelineTemplate {
    public AndroidPipeline(Project project, String link, String name) {
        super(project, link, name);
    }

    @Override
    public void run() {
        build();
        sign();
        test();
        publish();
    }
    @Override
    public void build(){
        System.out.println("gradlew build");
        System.out.println("------------------------");
    }
    public void sign(){
        System.out.println("Signing and Aligning APK files");
        System.out.println("------------------------");
    }
}
