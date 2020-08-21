package com.kyeljmd.ecommerce.gateway;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.kyeljmd.ecommerce.gateway");

        noClasses()
            .that()
                .resideInAnyPackage("com.kyeljmd.ecommerce.gateway.service..")
            .or()
                .resideInAnyPackage("com.kyeljmd.ecommerce.gateway.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.kyeljmd.ecommerce.gateway.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
