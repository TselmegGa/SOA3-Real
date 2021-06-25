import domain.Branch;
import domain.Project;
import domain.templates.AndroidPipeline;
import domain.templates.DotNetPipeline;
import domain.templates.NodeJSPipeline;
import domain.templates.PipelineTemplate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    @Test
    void BranchTest(){
        Project project = new Project();
        Branch branch = new Branch("Home page");
        String code = "<H1>Home Page</H1>";
        PipelineTemplate template = new DotNetPipeline(project,"Azure",".NET Pipeline 4", true);
        PipelineTemplate template2 = new AndroidPipeline(project,"Azure","Android Pipeline 1");
        PipelineTemplate template3 = new NodeJSPipeline(project,"Github", "NodeJS Pipeline 2","dir/js");
        ArrayList<PipelineTemplate> list = new ArrayList<>();
        list.add(template);
        Branch branch2 = new Branch(code ,"Home page",list);
        branch.setPipelines(new ArrayList<>());

        branch.addPipelines(template);
        branch.addPipelines(template2);
        branch.addPipelines(template3);

        branch.getPipelines().forEach(x -> x.run());


        branch.setCode(code);

        assertSame(branch.getCode(), code);
        assertSame(branch2.getPipelines().get(0), template);

    }
}
