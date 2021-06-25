import Domain.Branch;
import Domain.Project;
import Domain.Templates.AndroidPipeline;
import Domain.Templates.DotNetPipeline;
import Domain.Templates.NodeJSPipeline;
import Domain.Templates.PipelineTemplate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertTrue(branch.getCode() == code);
        assertTrue(branch2.getPipelines().get(0) == template);

    }
}
