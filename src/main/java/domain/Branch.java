package domain;

import domain.templates.PipelineTemplate;

import java.util.ArrayList;

public class Branch {
    private String code;
    private String name;
    private ArrayList<PipelineTemplate> pipelines;

    public Branch(String name) {
        this.name = name;
        pipelines = new ArrayList<>();
    }

    public Branch(String code, String name, ArrayList<PipelineTemplate> pipelines) {
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

    public ArrayList<PipelineTemplate> getPipelines() {
        return pipelines;
    }

    public void setPipelines(ArrayList<PipelineTemplate> pipelines) {
        this.pipelines = pipelines;
    }
    public void addPipelines(PipelineTemplate pipeline) {

        this.pipelines.add(pipeline);

    }
}
