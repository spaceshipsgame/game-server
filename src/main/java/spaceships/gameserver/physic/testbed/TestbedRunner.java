package spaceships.gameserver.physic.testbed;

import org.jbox2d.testbed.framework.TestList;
import org.jbox2d.testbed.framework.TestbedController;
import org.jbox2d.testbed.framework.TestbedFrame;
import org.jbox2d.testbed.framework.TestbedModel;
import org.jbox2d.testbed.framework.TestbedPanel;
import org.jbox2d.testbed.framework.TestbedSetting;
import org.jbox2d.testbed.framework.j2d.TestPanelJ2D;

import javax.swing.*;

public class TestbedRunner {

    public static void main(String[] args) {
        TestbedModel model = new TestbedModel();         // create our model

// add tests
        TestList.populateModel(model);                   // populate the provided testbed tests
        model.addCategory("Spaceships Tests");             // add a category
        model.addTest(new GameTestbedModel());                // add our test

        TestbedPanel panel = new TestPanelJ2D(model);    // create our testbed panel

        JFrame testbed = new TestbedFrame(model, panel, TestbedController.UpdateBehavior.UPDATE_CALLED); // put both into our testbed frame
// etc
        testbed.setVisible(true);
        testbed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

