package com.tjetc.pojo;

public class SerResult {
    private String id;//编号

    private String result;//处理结果

    private Integer satisfied;//满意度（1~5）1~5星
    
    private SerCj serCj;
    
    

    public SerResult(String result, Integer satisfied, SerCj serCj) {
		super();
		this.result = result;
		this.satisfied = satisfied;
		this.serCj = serCj;
	}

	
	public SerCj getSerCj() {
		return serCj;
	}


	public void setSerCj(SerCj serCj) {
		this.serCj = serCj;
	}


	public SerResult(SerCj serCj) {
		super();
		this.serCj = serCj;
	}


	public SerResult(String id, String result, Integer satisfied, SerCj serCj) {
		super();
		this.id = id;
		this.result = result;
		this.satisfied = satisfied;
		this.serCj = serCj;
	}

	public SerResult() {
		super();
	}

	public SerResult(String id, String result, Integer satisfied) {
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

	public String getId() {
		return id;
	}

	public String getResult() {
		return result;
	}

	public Integer getSatisfied() {
		return satisfied;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setSatisfied(Integer satisfied) {
		this.satisfied = satisfied;
	}

	@Override
	public String toString() {
		return "SerResult [id=" + id + ", result=" + result + ", satisfied=" + satisfied + "]";
	}


    
}