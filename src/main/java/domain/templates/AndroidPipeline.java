package domain.templates;

import domain.Project;


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
        logger.info("gradlew build");

    }
    private void sign(){
        logger.info("Signing and Aligning APK files");

    }
}
