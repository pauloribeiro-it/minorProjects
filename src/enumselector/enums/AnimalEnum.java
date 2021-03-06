package enumselector.enums;

import enumselector.annotations.AttributeSelector;

public enum AnimalEnum {
	DOG("Dog",1),
	CAT("Cat",2),
	SNAKE("Snake",3);
	
	private String description;
	private Integer code;
	
	private AnimalEnum(String description, Integer code){
		this.description = description;
		this.code = code;
	}
	
	@AttributeSelector("desc")
	public String getDescription() {
		return description;
	}
	
	@AttributeSelector("cod")
	public Integer getCode() {
		return code;
	}
	
}
