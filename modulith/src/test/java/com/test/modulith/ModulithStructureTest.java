package com.test.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModulithStructureTest {

    @Test
    void verifiesModuleDependencies() {
        ApplicationModules.of(ModulithApplication.class).verify();
    }
}
