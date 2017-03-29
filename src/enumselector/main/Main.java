package enumselector.main;

import java.lang.reflect.InvocationTargetException;

import enumselector.enums.AnimalEnum;
import enumselector.selector.EnumRecover;

public class Main {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		System.out.println(new EnumRecover<AnimalEnum>().recoverEnum(AnimalEnum.class, "desc","Dog"));
	}
}
