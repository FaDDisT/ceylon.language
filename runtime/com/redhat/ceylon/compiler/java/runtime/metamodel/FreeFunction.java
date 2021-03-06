package com.redhat.ceylon.compiler.java.runtime.metamodel;

import java.lang.annotation.Annotation;
import java.util.List;

import ceylon.language.Iterator;
import ceylon.language.Sequential;
import ceylon.language.empty_;
import ceylon.language.finished_;
import ceylon.language.model.declaration.FunctionDeclaration$impl;
import ceylon.language.model.declaration.FunctionalDeclaration$impl;
import ceylon.language.model.declaration.GenericDeclaration$impl;
import ceylon.language.model.declaration.OpenType;

import com.redhat.ceylon.compiler.java.Util;
import com.redhat.ceylon.compiler.java.metadata.Ceylon;
import com.redhat.ceylon.compiler.java.metadata.Ignore;
import com.redhat.ceylon.compiler.java.metadata.Name;
import com.redhat.ceylon.compiler.java.metadata.Sequenced;
import com.redhat.ceylon.compiler.java.metadata.TypeInfo;
import com.redhat.ceylon.compiler.java.runtime.model.TypeDescriptor;
import com.redhat.ceylon.compiler.typechecker.model.Functional;
import com.redhat.ceylon.compiler.typechecker.model.Generic;
import com.redhat.ceylon.compiler.typechecker.model.Method;
import com.redhat.ceylon.compiler.typechecker.model.Parameter;
import com.redhat.ceylon.compiler.typechecker.model.ParameterList;
import com.redhat.ceylon.compiler.typechecker.model.ProducedType;
import com.redhat.ceylon.compiler.typechecker.model.ProducedTypedReference;

@Ceylon(major = 5)
@com.redhat.ceylon.compiler.java.metadata.Class
public class FreeFunction 
    extends FreeFunctionOrValue
    implements ceylon.language.model.declaration.FunctionDeclaration, AnnotationBearing {

    @Ignore
    public static final TypeDescriptor $TypeDescriptor = TypeDescriptor.klass(FreeFunction.class);
    
    private Sequential<? extends ceylon.language.model.declaration.TypeParameter> typeParameters;
    
    private OpenType type;

    private Sequential<? extends ceylon.language.model.declaration.FunctionOrValueDeclaration> parameterList;

    public FreeFunction(com.redhat.ceylon.compiler.typechecker.model.TypedDeclaration declaration) {
        super(declaration);

        // FIXME: make lazy
        // FIXME: share with ClassOrInterface
        List<com.redhat.ceylon.compiler.typechecker.model.TypeParameter> typeParameters = ((Functional) declaration).getTypeParameters();
        ceylon.language.model.declaration.TypeParameter[] typeParametersArray = new ceylon.language.model.declaration.TypeParameter[typeParameters.size()];
        int i=0;
        for(com.redhat.ceylon.compiler.typechecker.model.TypeParameter tp : typeParameters){
            typeParametersArray[i++] = new com.redhat.ceylon.compiler.java.runtime.metamodel.FreeTypeParameter(tp);
        }
        this.typeParameters = (Sequential)Util.sequentialInstance(ceylon.language.model.declaration.TypeParameter.$TypeDescriptor, typeParametersArray);
        
        this.type = Metamodel.getMetamodel(declaration.getType());
        
        List<ParameterList> parameterLists = ((Functional)declaration).getParameterLists();
        ParameterList parameterList = parameterLists.get(0);
        List<Parameter> modelParameters = parameterList.getParameters();
        ceylon.language.model.declaration.FunctionOrValueDeclaration[] parameters = new ceylon.language.model.declaration.FunctionOrValueDeclaration[modelParameters.size()];
        i=0;
        for(Parameter modelParameter : modelParameters){
            parameters[i] = (ceylon.language.model.declaration.FunctionOrValueDeclaration)Metamodel.getOrCreateMetamodel(modelParameter.getModel());
            i++;
        }
        this.parameterList = Util.sequentialInstance(ceylon.language.model.declaration.FunctionOrValueDeclaration.$TypeDescriptor, parameters);
    }

    @Override
    @Ignore
    public FunctionDeclaration$impl $ceylon$language$model$declaration$FunctionDeclaration$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Ignore
    public FunctionalDeclaration$impl $ceylon$language$model$declaration$FunctionalDeclaration$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Ignore
    public GenericDeclaration$impl $ceylon$language$model$declaration$GenericDeclaration$impl() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @TypeInfo("ceylon.language::Sequential<ceylon.language.model.declaration::FunctionOrValueDeclaration>")
    public Sequential<? extends ceylon.language.model.declaration.FunctionOrValueDeclaration> getParameterDeclarations(){
        return parameterList;
    }

    @Override
    @TypeInfo("ceylon.language.model.declaration::FunctionOrValueDeclaration|ceylon.language::Null")
    public ceylon.language.model.declaration.FunctionOrValueDeclaration getParameterDeclaration(@Name("name") String name){
        Iterator<?> iterator = parameterList.iterator();
        Object o;
        while((o = iterator.next()) != finished_.$get()){
            ceylon.language.model.declaration.FunctionOrValueDeclaration pd = (ceylon.language.model.declaration.FunctionOrValueDeclaration) o;
            if(pd.getName().equals(name))
                return pd;
        }
        return null;
    }

    @Override
    @TypeInfo("ceylon.language::Sequential<ceylon.language.model.declaration::TypeParameter>")
    public Sequential<? extends ceylon.language.model.declaration.TypeParameter> getTypeParameterDeclarations() {
        return typeParameters;
    }

    @Override
    @TypeInfo("ceylon.language.model.declaration::TypeParameter|ceylon.language::Null")
    public ceylon.language.model.declaration.TypeParameter getTypeParameterDeclaration(@Name("name") String name) {
        Iterator<? extends ceylon.language.model.declaration.TypeParameter> iterator = typeParameters.iterator();
        Object it;
        while((it = iterator.next()) != finished_.$get()){
            ceylon.language.model.declaration.TypeParameter tp = (ceylon.language.model.declaration.TypeParameter) it;
            if(tp.getName().equals(name))
                return tp;
        }
        return null;
    }

    @Ignore
    @Override
    public Sequential<? extends ceylon.language.model.Type<?>> apply$types(){
        return (Sequential) empty_.$get();
    }

    @Ignore
    @Override
    public ceylon.language.model.Function<? extends Object, ? super Sequential<? extends Object>> apply(){
        return apply(apply$types());
    }

    @Override
    @TypeInfo("ceylon.language.model::Function<ceylon.language::Anything,ceylon.language::Nothing>")
    public ceylon.language.model.Function<? extends Object, ? super Sequential<? extends Object>> apply(@Name("types") @TypeInfo("ceylon.language::Sequential<ceylon.language.model::Type<ceylon.language::Anything>>") @Sequenced Sequential<? extends ceylon.language.model.Type<?>> types){
        return bindAndApply(null, types);
    }

    @Ignore
    @Override
    public Sequential<? extends ceylon.language.model.Type<?>> bindAndApply$types(Object instance){
        return (Sequential) empty_.$get();
    }

    @Ignore
    @Override
    public ceylon.language.model.Function<? extends Object, ? super Sequential<? extends Object>> bindAndApply(Object instance){
        return bindAndApply(instance, bindAndApply$types(instance));
    }

    @Override
    @TypeInfo("ceylon.language.model::Function<ceylon.language::Anything,ceylon.language::Nothing>")
    public ceylon.language.model.Function<? extends Object, ? super Sequential<? extends Object>> bindAndApply(
            @Name("instance") @TypeInfo("ceylon.language::Object") Object instance, 
            @Name("types") @TypeInfo("ceylon.language::Sequential<ceylon.language.model::Type<ceylon.language::Anything>>") @Sequenced Sequential<? extends ceylon.language.model.Type<?>> types){
        List<com.redhat.ceylon.compiler.typechecker.model.ProducedType> producedTypes = Metamodel.getProducedTypes(types);
        // FIXME: should have the container type
        com.redhat.ceylon.compiler.typechecker.model.ProducedReference appliedFunction = declaration.getProducedReference(null, producedTypes);
        TypeDescriptor reifiedType = Metamodel.getTypeDescriptorForFunction(appliedFunction);
        TypeDescriptor reifiedArguments = Metamodel.getTypeDescriptorForArguments(declaration.getUnit(), (Functional) declaration, appliedFunction);
        return new AppliedFunction(reifiedType, reifiedArguments, appliedFunction, this, instance);
    }

    @Ignore
    @Override
    public <Container, Type, Arguments extends Sequential<? extends Object>>
        Sequential<? extends ceylon.language.model.Type<?>> memberApply$types(TypeDescriptor $reifiedContainer,
                                                                               TypeDescriptor $reifiedType,
                                                                               TypeDescriptor $reifiedArguments){
        
        return (Sequential) empty_.$get();
    }

    @Ignore
    @Override
    public <Container, Type, Arguments extends Sequential<? extends Object>>
        ceylon.language.model.Method<Container, Type, Arguments> memberApply(TypeDescriptor $reifiedContainer,
                                                                                 TypeDescriptor $reifiedType,
                                                                                 TypeDescriptor $reifiedArguments){
        
        return this.<Container, Type, Arguments>memberApply($reifiedContainer,
                                                            $reifiedType,
                                                            $reifiedArguments,
                                                            this.<Container, Type, Arguments>memberApply$types($reifiedContainer, $reifiedType, $reifiedArguments));
    }

    @Override
    public <Container, Type, Arguments extends Sequential<? extends Object>>
        ceylon.language.model.Method<Container, Type, Arguments> memberApply(
                @Ignore TypeDescriptor $reifiedContainer,
                @Ignore TypeDescriptor $reifiedType,
                @Ignore TypeDescriptor $reifiedArguments,
                @Name("types") @Sequenced Sequential<? extends ceylon.language.model.Type<?>> types){
        // FIXME: container?
        return getAppliedMethod($reifiedContainer, $reifiedType, $reifiedArguments, types, null);
    }

    <Container, Type, Arguments extends ceylon.language.Sequential<? extends Object>>
    ceylon.language.model.Method<Container, Type, Arguments> getAppliedMethod(@Ignore TypeDescriptor $reifiedContainer, 
                                                                                  @Ignore TypeDescriptor $reifiedType, 
                                                                                  @Ignore TypeDescriptor $reifiedArguments, 
                                                                                  Sequential<? extends ceylon.language.model.Type<?>> types,
                                                                                  ceylon.language.model.ClassOrInterface<? extends Object> container){
        // if we don't have any TP our declaration will also be a Method
        if(!Metamodel.hasTypeParameters((Generic) declaration))
            return (ceylon.language.model.Method)Metamodel.getOrCreateMetamodel(declaration);
        List<com.redhat.ceylon.compiler.typechecker.model.ProducedType> producedTypes = Metamodel.getProducedTypes(types);
        // FIXME: check this null qualifying type
        // this is most likely wrong as it doesn't seem to substitute the containing type parameters
        ProducedType containerType = null;
        if(container != null){
            containerType = Metamodel.getModel(container);
        }
        final ProducedTypedReference appliedFunction = ((com.redhat.ceylon.compiler.typechecker.model.TypedDeclaration)declaration).getProducedTypedReference(containerType, producedTypes);
        return new AppliedMethod($reifiedContainer, $reifiedType, $reifiedArguments, appliedFunction, this, container);
    }
    
    @Override
    @TypeInfo("ceylon.language.model.declaration::OpenType")
    public OpenType getOpenType() {
        return type;
    }

    @Ignore
    @Override
    public TypeDescriptor $getType() {
        return $TypeDescriptor;
    }

    @Ignore
    @Override
    public java.lang.annotation.Annotation[] $getJavaAnnotations() {
        // FIXME: this could be a FunctionalParameter!
        return Metamodel.getJavaMethod((Method) declaration).getAnnotations();
    }
}
