package com.tjetc.pojo;

public class SerResult {
    private Integer id;//编号

    private String result;//处理结果

    private Integer satisfied;//满意度（1~5）1~5星

    public SerResult() {
		super();
	}

	public SerResult(Integer id, String result, Integer satisfied) {
		super();
		this.id = id;
		this.result = result;
		this.satisfied = satisfied;
	}

	public SerResult(String result, Integer satisfied) {
		super();
		this.result = result;
		this.satisfied = satisfied;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Integer getSatisfied() {
        return satisfied;
    }

    public void setSatisfied(Integer satisfied) {
        this.satisfied = satisfied;
    }

	@Override
	public String toString() {
		return "SerResult [id=" + id + ", result=" + result + ", satisfied=" + satisfied + "]";
	}
    
}