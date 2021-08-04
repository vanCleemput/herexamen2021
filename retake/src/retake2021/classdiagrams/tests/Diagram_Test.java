package retake2021.classdiagrams.tests;
import retake2021.classdiagrams.AssociationLine;
import retake2021.classdiagrams.ClassBox;
import retake2021.classdiagrams.Multiplicity;
import retake2021.classdiagrams.Role;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Diagram_Test {
    @Test
    void test() {
        ClassBox startClassBox = new ClassBox("student");
        ClassBox endClassBox = new ClassBox("Team");
        Map<String,Role> roleSet = new HashMap<>();
        /// test getters classBox/////////////////////
        assertEquals(startClassBox.getName(),"student");
        assertEquals(roleSet,startClassBox.getRoles());
        assertEquals(roleSet,endClassBox.getRoles());


        //////////////////////////////////////:
        String startRoleName = "member";
        String endRoleName = "team";
        Multiplicity startRoleMultiplicity = Multiplicity.ZERO_TO_MANY;
        Multiplicity endRoleMultiplicity = Multiplicity.ZERO_TO_ONE;

        AssociationLine associationLine1 = new AssociationLine(startClassBox, startRoleName, startRoleMultiplicity
                , endClassBox, endRoleName, endRoleMultiplicity);

        // test getters role

        Role startRole = associationLine1.getInternalStartRole();
        Role endRole = associationLine1.getInternalEndRole();
        assertEquals(startRole.getName(),startRoleName);
        assertEquals(startRole.getClassBox(),startClassBox);
        assertEquals(startRole.getMultiplicity(),startRoleMultiplicity);
        assertEquals(startRole.getAssociationLine(),associationLine1);

        /// test assoctionline
        assertEquals(associationLine1.getStartRole().getAssociationLine(),associationLine1);
        assertEquals(associationLine1.getEndRole().getAssociationLine(),associationLine1);
        assertFalse(associationLine1.isDeleted());
        assertTrue(associationLine1.getEndRole().getClassBox().getRoles().containsKey(endRoleName));
        assertTrue(associationLine1.getStartRole().getClassBox().getRoles().containsKey(startRoleName));

        ///test associationLine deleted
        associationLine1.delete();
       // assertTrue(associationLine1.isDeleted());
        //assertNull(associationLine1.getStartRole());
        //assertNull(associationLine1.getEndRole());
        /*assertNull(startRole.getAssociationLine());
        assertNull(startRole.getClassBox());
        assertNull(endRole.getClassBox());

        assertNull(endRole.getAssociationLine());

        assertEquals(roleSet,startClassBox.getRoles());
        assertEquals(roleSet,endClassBox.getRoles());



         */




    }
    @Test
    void testRoles() {
        //Role test = new Role();
    }

}
