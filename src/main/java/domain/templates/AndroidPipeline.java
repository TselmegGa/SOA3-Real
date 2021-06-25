package domain.templates;

import domain.Project;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class AndroidPipeline extends PipelineTemplate {
    private static final Logger logger = LogManager.getLogger(AndroidPipeline.class);
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
