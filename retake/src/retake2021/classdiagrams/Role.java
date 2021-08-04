package retake2021.classdiagrams;
// ik kan wrsh best de collections gebruiken van hem
/*
/**
 * @invar | getName()!=null
 * @invar | getMultiplicity()!=null
 * @invar | getAssociationLine()==null || getAssociationLine().getStartRole() == this
 *                                      || getAssociationLine().getEndRole() == this
 * @invar | getClassBox() == null || getClassBox().getRoles().containsKey(getName())
 *                                  && getClassBox().getRoles().containsValue(this)
 *
 */


public class Role {
    private String name;
    private Multiplicity multiplicity;
    // ik denkt dat de volgende twee objecte beide peerobjecten zijn TODO
    private AssociationLine associationLine;
    private ClassBox classBox;
    /// niet zeker of dit mag maar anders zou de klant een lijst van classbox moeten bijhouden waarover geiterate moet worden
    //// dit is een peerobject een role kan niet bestaan zonder een classbox waar die toebehoord


    protected Role(String name, Multiplicity multiplicity, AssociationLine associationLine, ClassBox classBox) {
        if (classBox == null) {
            throw new IllegalArgumentException("classbox was null");
        }
        if (name==null||multiplicity==null||associationLine==null){
            throw new IllegalArgumentException("one of the parrameters was null when the role was constructed");
        }
        this.name = name;
        this.multiplicity = multiplicity;
        this.associationLine = associationLine;
        this.classBox = classBox;
    }
    public ClassBox getClassBox() {
        if (associationLine==null)return null;

        return classBox;
    }

    public String getName() {
        return name;
    }

    public Multiplicity getMultiplicity() {
        return multiplicity;
    }
    // TODO ik denk dat ik dit nog steeds moet aanpassen zodat het een clone door geeft opdeze manier blijft het verband intact
    public AssociationLine getAssociationLine() {
        //ik kan deze nergens gelijk aan stellen dus ik denk dat ik deze dan miss ook niet moet aanpassen ?
        // maar miss wnr de client de velden veranderen miss gebeurt dit dan ook met het oorspronkelijk object
        return associationLine;
    }

    protected void deleteClassBox(){
        classBox.getInternalRoleSet().remove(this);
        classBox=null;
    }
    protected void deleteAssociationLine(){
        associationLine=null;
    }
    protected Role clone(){
        return new Role(name, multiplicity, associationLine, classBox);
    }

}
