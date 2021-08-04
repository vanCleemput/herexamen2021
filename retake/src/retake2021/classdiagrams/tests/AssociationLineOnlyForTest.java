package retake2021.classdiagrams.tests;

import retake2021.classdiagrams.AssociationLine;
import retake2021.classdiagrams.ClassBox;
import retake2021.classdiagrams.Multiplicity;

public class AssociationLineOnlyForTest extends AssociationLine {

    public AssociationLineOnlyForTest(ClassBox startClassBox, String startRoleName, Multiplicity startRoleMultiplicity, ClassBox endClassBox, String endRoleName, Multiplicity endRoleMultiplicity) {
        super(startClassBox, startRoleName, startRoleMultiplicity, endClassBox, endRoleName, endRoleMultiplicity);
    }
}
