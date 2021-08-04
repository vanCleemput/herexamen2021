package retake2021.classdiagrams;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
// volgens mij omdat mijn variabee private zijn moet ik geen invar schrijven voor de de velden appart
//en omdat de klant geen toegang heeft tot getInternalRolesSet moet hier dus ook niet vermeld worden
/*
/**
 * @invar | getRoles()!=null
 * @invar | getRoles().entrySet().stream().allMatch(role->((role.getValue()!= null) && (role.getValue().getClassBox() == this) && role.getKey().equals(role.getValue().getName())))
 * @invar | getName()!=null
 *
 *
 */
public class ClassBox {
    private String name;
    /*
    /**
     * @representationObject
     * @peerObjects
     */
    private Set<Role> roles = new HashSet<>();
/*
    /**
     *
     * @post | getName() == name
     */
    public ClassBox(String name) {
        if (name==null) throw new IllegalArgumentException("name can't be null");
        this.name = name;




    }

    ////dit mag hier niet je mag enkel defensief programeren bij de constructer hier moet het contractueel
    // Dit hoort bij het construeren van een role object dus ik zou denken defensief
    // TODO
    /// hier moet ik geen documentatie schrijven want deze is private de klant heeft geen toegang tot deze functie
    protected void addRoleToSet(Role role) {
        if (roles.contains(role)) {
            throw new IllegalArgumentException("this role is already a part of the roles set ");
        }
        if(roles.stream().anyMatch(e->e.getName()==role.getName())){
            throw new IllegalArgumentException("there is already a role present in the set with the same name ");
        }

        roles.add(role);
    }
    /// dit is de internal representatie dus deze mag geen copy zijn zodat inpackege deze lijst kan aangepast worden
    protected Set<Role> getInternalRoleSet() {
        return roles;
    }

    public String getName() {
        return name;
    }

    //  formele documentatie TODO////
    public Map<String, Role> getRoles() {
        return roles.stream().collect(Collectors.toMap(Role::getName,role -> role));
    }
}
