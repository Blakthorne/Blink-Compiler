package org.main.decl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Decl {
    protected String name;
    protected Type type;
    protected Integer level;

    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper=true)
    public static class ClassDecl extends Decl {
        protected ClassDecl parent;
        protected List<MethodDecl> methods = new ArrayList<>();
        protected List<ArgDecl> arguments = new ArrayList<>();
        protected List<VarDecl> variables = new ArrayList<>();

        public ClassDecl(String name, Type type, Integer level) {
            super(name, type, level);
        }

        public List<VarDecl> getVars() {
            return variables;
        }

        public Optional<MethodDecl> lookupMethod(String name) {
            for(var method : methods) {
                if(method.getName().equals(name)) {
                    return Optional.of(method);
                }
            }
            if(parent != null) {
                return parent.lookupMethod(name);
            }
            return Optional.empty();
        }

        public Optional<ArgDecl> lookupArgument(String name) {
            for(var arg : arguments) {
                if(arg.getName().equals(name)) {
                    return Optional.of(arg);
                }
            }
            if(parent != null) {
                return parent.lookupArgument(name);
            }
            return Optional.empty();
        }

        public Optional<VarDecl> lookupVariable(String name) {
            for(var var : variables) {
                if(var.getName().equals(name)) {
                    return Optional.of(var);
                }
            }
            if(parent != null) {
                return parent.lookupVariable(name);
            }
            return Optional.empty();
        }
    }

    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper=true)
    public static class MethodDecl extends Decl {
        protected List<MethodDecl> methods = new ArrayList<>();
        protected List<ArgDecl> arguments = new ArrayList<>();
        protected List<VarDecl> variables = new ArrayList<>();

        public MethodDecl(String name, Type type, Integer level) {
            super(name, type, level);
        }

        public List<VarDecl> getVars() {
            return variables;
        }

        public Optional<MethodDecl> lookupMethod(String name) {
            for(var method : methods) {
                if(method.getName().equals(name)) {
                    return Optional.of(method);
                }
            }
            return Optional.empty();
        }

        public Optional<ArgDecl> lookupArgument(String name) {
            for(var arg : arguments) {
                if(arg.getName().equals(name)) {
                    return Optional.of(arg);
                }
            }
            return Optional.empty();
        }

        public Optional<VarDecl> lookupVariable(String name) {
            for(var var : variables) {
                if(var.getName().equals(name)) {
                    return Optional.of(var);
                }
            }
            return Optional.empty();
        }
    }

    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper=true)
    public static class ArgDecl extends Decl {
        protected Integer position;

        public ArgDecl(String name, Type type, Integer level, Integer position) {
            super(name, type, level);
            this.position = position;
        }
    }

    @Data
    @NoArgsConstructor
    @EqualsAndHashCode(callSuper=true)
    public static class VarDecl extends Decl {
        public VarDecl(String name, Type type, Integer level) {
            super(name, type, level);
        }
    }
}
