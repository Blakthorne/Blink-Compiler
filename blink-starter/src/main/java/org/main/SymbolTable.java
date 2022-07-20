package org.main;

import org.main.decl.Decl;
import org.main.decl.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SymbolTable {
    public List<List<Decl>> symbolTable = new ArrayList<>();

    public SymbolTable() {
        this.symbolTable.add(new ArrayList<>());

        // setup standard library
        // readint
        this.add(new Decl.MethodDecl("readint", Type.INT, 0));

        // readchar
        this.add(new Decl.MethodDecl("readchar", Type.INT, 0));

        // readstring
        this.add(new Decl.MethodDecl("readstring", Type.STRING, 0));

        // printint
        Decl.MethodDecl printint = new Decl.MethodDecl("printint", Type.INT, 0);
        printint.getArguments().add(new Decl.ArgDecl("x", Type.INT, 1, 0));
        this.add(printint);

        // printchar
        Decl.MethodDecl printchar = new Decl.MethodDecl("printchar", Type.INT, 0);
        printchar.getArguments().add(new Decl.ArgDecl("x", Type.INT, 1, 0));
        this.add(printchar);

        // printstring
        Decl.MethodDecl printstring = new Decl.MethodDecl("printstring", Type.STRING, 0);
        printstring.getArguments().add(new Decl.ArgDecl("x", Type.STRING, 1, 0));
        this.add(printstring);

        // getchar
        Decl.MethodDecl getchar = new Decl.MethodDecl("getchar", Type.INT, 0);
        getchar.getArguments().add(new Decl.ArgDecl("x", Type.STRING, 1, 0));
        getchar.getArguments().add(new Decl.ArgDecl("pos", Type.INT, 1, 1));
        this.add(getchar);

        // setchar
        Decl.MethodDecl setchar = new Decl.MethodDecl("setchar", Type.INT, 0);
        setchar.getArguments().add(new Decl.ArgDecl("x", Type.STRING, 1, 0));
        setchar.getArguments().add(new Decl.ArgDecl("pos", Type.INT, 1, 1));
        setchar.getArguments().add(new Decl.ArgDecl("z", Type.INT, 1, 2));
        this.add(setchar);

        // setchar
        Decl.MethodDecl getlength = new Decl.MethodDecl("getlength", Type.INT, 0);
        getlength.getArguments().add(new Decl.ArgDecl("x", Type.STRING, 1, 0));
        this.add(getlength);
    }

    public <T extends Decl> Optional<T> lookup(String name, Class<T> clazz) {
        for(int i = this.symbolTable.size() - 1; i >= 0; --i) {
            for(var entry : this.symbolTable.get(i)) {
                if(clazz.equals(entry.getClass()) && name.equals(entry.getName())) {
                    return Optional.of((T) entry);
                }
            }
        }
        return Optional.empty();
    }

    public void add(Decl decl) {
        this.symbolTable.get(this.symbolTable.size() - 1).add(decl);
    }

    public void push() {
        this.symbolTable.add(new ArrayList<>());
    }

    public void pop() {
        var primary = this.symbolTable.get(this.symbolTable.size() - 1).get(0);
        this.symbolTable.remove(this.symbolTable.size() - 1);
        this.symbolTable.get(this.symbolTable.size() - 1).add(primary);
    }

    public Integer getCurrentLevel() {
        return this.symbolTable.size();
    }

    public Optional<Decl.ClassDecl> getCurrentClass() {
        if(this.symbolTable.size() > 1 && this.symbolTable.get(1).size() > 0) {
            var rootOfCurrentLevel = this.symbolTable.get(1).get(0);
            if(rootOfCurrentLevel instanceof Decl.ClassDecl) {
                return Optional.of((Decl.ClassDecl) rootOfCurrentLevel);
            }
        }
        return Optional.empty();
    }

    public Optional<Decl.MethodDecl> getCurrentMethod() {
        if(this.symbolTable.get(this.symbolTable.size() - 1).size() > 0) {
            var rootOfCurrentLevel = this.symbolTable.get(this.symbolTable.size() - 1).get(0);
            if(rootOfCurrentLevel instanceof Decl.MethodDecl) {
                return Optional.of((Decl.MethodDecl) rootOfCurrentLevel);
            }
        }
        return Optional.empty();
    }

    public List<Decl.VarDecl> getGlobalVariables() {
        List<Decl.VarDecl> decls = new ArrayList<>();
        var stuff = symbolTable.get(0);
        for(var thing : stuff) {
            if (thing instanceof Decl.ClassDecl) {
                for (var thing2 : ((Decl.ClassDecl) thing).getVars()) {
                    decls.add(thing2);
                }
            }
            if (thing instanceof Decl.MethodDecl) {
                for (var thing2 : ((Decl.MethodDecl) thing).getVars()) {
                    decls.add(thing2);
                }
            }
            if(thing instanceof Decl.VarDecl) {
                decls.add((Decl.VarDecl) thing);
            }
        }
        return decls;
    }
}
