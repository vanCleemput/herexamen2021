package retake2021.classdiagrams;

// eerste invar moet aangepast worden als ik beslis om het object toch te clone dan moet ik nog een interne maken
/*
/**
 * @invar | getStartRole() == null || getStartRole().getAssociationLine()==this
 * @invar | getEndRole() == null || getEndRole().getAssociationLine()==this
 *
 */
public class AssociationLine {
    /*
    /**
     * @peeronjects
     */
    private Role startRole;
    private Role endRole;
    private boolean deleted = false;
/*
    /**
     * @post | getStartRole().getName() == startRoleName
     * @post | getStartRole().getMultiplicity() == startRoleMultiplicity
     * @post | getStartRole().getClassBox() == startClassBox
     * @post | getStartRole().getAssociationLine() == this
     *
     * @post | getEndRole().getName() == endRoleName
     * @post | getEndRole().getMultiplicity() == endRoleMultiplicity
     * @post | getEndRole().getClassBox() == endClassBox
     * @post | getEndRole().getAssociationLine() == this
     *
     * @post | startClassBox.getRoles().containsValue(getStartRole()) && startClassBox.getRoles().containsKey(getStartRole().getName())
     * @post | endClassBox.getRoles().containsValue(getEndRole()) && endClassBox.getRoles().containsKey(getEndRole().getName())
     */
    public AssociationLine(ClassBox startClassBox,String startRoleName, Multiplicity startRoleMultiplicity,ClassBox endClassBox, String endRoleName, Multiplicity endRoleMultiplicity) {
        if(startClassBox.equals(endClassBox)){
            throw new IllegalArgumentException("startClassBox and endClassBox were the same this is not allowed");
        }
        startRole = new Role(startRoleName, startRoleMultiplicity, this,startClassBox);
        startClassBox.addRoleToSet(startRole);
        endRole = new Role(endRoleName, endRoleMultiplicity, this,endClassBox);
        endClassBox.addRoleToSet(endRole);
    }
    /// moet een kopie zijn ? want de klant mag deze niet kunnen veranderen want anders breekt dit de associatie
    public Role getStartRole() {
        if (startRole==null)return null;
        return startRole;
    }
    /// is inderdaa hetzelfde object
    public  Role getInternalStartRole(){return startRole;}
    /// moet een kopie zijn ? want de klant mag deze niet kunnen veranderen want anders breekt dit de associatie
    public Role getInternalEndRole(){return endRole;}
    public Role getEndRole() {
        if (startRole==null)return null;
        return endRole;
    }

    //// ik weet niet of dit een corecte manier is want wa als een can de roles null is maar e andere niet ?
    //// wat bedoelen ze juist met startRole en endRole ?
    ////men mag geen assosatie maken wnr een van de twee rolen nul zijn
    public boolean isDeleted(){
        return deleted;
    }
    //// beide role objecten moeten verwijerd worden
    //// kan een role bestaan zonder associatie ? ik denk het niet omdat er in de tekst niet wordt gezeg dat de klant een role kan moeten aanmaken
    /// zo ja dan moet het ook verwijerd worden uit de classbox
    //ik moet assosiatieline kunnen verwijderen dit gaat niet door deze internal gelijk aan null te zetten
    // miss hetzelfde bij andere objecten miss moet ik niet clone moet ik nog testen
    // is het genoeg om deze aan null gelijk te stellen ?///
/*
    /**
     * @pre | isDeleted()!=true
     * @post | !(getStartRole().getClassBox().getRoles().containsValue(getStartRole()) && getStartRole().getClassBox().getRoles().containsKey(getStartRole().getName()))
     * @post | !(getEndRole().getClassBox().getRoles().containsValue(getEndRole()) && getEndRole().getClassBox().getRoles().containsKey(getEndRole().getName()))
     */

    public void delete() {
        // hier gaan we gebruik maken van de interne representatie van de set van roles
        //TODO
        if(!isDeleted()) {
            startRole.deleteClassBox();
            // startRole.deleteAssociationLine();
            endRole.deleteClassBox();
            deleted =true;
            // endRole.deleteAssociationLine();
            //startRole = null;
            //endRole = null;
        }

    }
}
