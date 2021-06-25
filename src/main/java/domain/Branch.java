package domain;

import domain.templates.PipelineTemplate;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String code;
    private String name;
    private List<PipelineTemplate> pipelines;

    public Branch(String name) {
        this.name = name;
        pipelines = new ArrayList<>();
    }

    public Branch(String code, String name, List<PipelineTemplate> pipelines) {
        this.code = code;
        this.name = name;
        this.pipelines = pipelines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<PipelineTemplate> getPipelines() {
        return pipelines;
    }

    public void setPipelines(List<PipelineTemplate> pipelines) {
        this.pipelines = pipelines;
    }
    public void addPipelines(PipelineTemplate pipeline) {

        this.pipelines.add(pipeline);

    }
}
