import ceylon.language.metamodel{Annotated}

shared interface Declaration of Value |
                                FunctionDeclaration |
                                ClassOrInterfaceDeclaration
        satisfies Annotated {
    
    shared formal String name;
    
    shared formal Annotation[] annotations<Annotation>()
            given Annotation satisfies Object;
    
    // FIXME: that name sucks
    shared formal Package packageContainer;
    
    shared formal Boolean toplevel;
}