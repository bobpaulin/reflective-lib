package com.bobpaulin.graal.component.sub.impl;

import com.bobpaulin.graal.component.Something;
import com.bobpaulin.graal.component.impl.DoSomethingElse;
import com.bobpaulin.graal.main.LibraryMain;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(LibraryMain.class)
final class SubstituteLibraryMain {
	
	@Substitute
	Something somethingFactory() {
		return new DoSomethingElse();
	}

}