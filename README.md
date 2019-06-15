“Screen-validator" is a tool which helps to find layout regression bugs in different browsers (including mobile devices and tablets).
This tool has 2 modes: 
1. a run with pre-taken screenshots. In this mode, we have the screenshots taken of the previous stable version of the system and we want to compare them with new ones in order to find unexpected layout (visual) changes. 












To have such screenshots which we treat as expected results we should run same scenarios on the other environment where we have the old version of the system or on the same environment but before new changes was released there.


















2. a concurrent run mode. In this mode we have 2 instances of tests run in parallel(same browser, same screen resolution, same scenarios (pages)) different environments with different versions (but with the same content) the app. On every valuable step, we take a screenshot in both instances and store them according to a hierarchy (session/device/region/language/browser/nameOfTheScenario_i++). After run completion, we compare all screenshots correspondingly and make diffs of the images.















Details:
Ideally all scenarios should contain only list of pages to get to in order to take a screenshot but there are always some forms which require some actions on the page to reach them so scenarios might contain some actions with the website (click, hover, type, etc.). But we should minimize such cases to not bind the tool with UI elements. 
Chrome driver with enabled Mobile Emulation feature will be used to emulate running tests on mobile devices chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
If we have a dynamic content on the page which is not under our control (like Twitter feed) then we can take a screenshot of particular elements on the page instead of taking the whole page.
In the config file or via Jenkins job we can set desired configurations for the current run, for instance if we specify the region which does not have Manage Account component then such scenarios will be ignored (there should be a mapping regions-excluded features)
All browsers will be on in full-screen mode (if other not specified in the config file)

Technologies: Java, Selenide, aShot, Chromedriver

















