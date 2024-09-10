package com.codurance.ocp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeShould {

    @Test
    public void not_add_bonus_to_the_engineer_pay_amount() {
        Employee engineer = new Engineer(1000);
        assertThat(engineer.payAmount()).isEqualTo(1000);
    }

    @Test
    public void add_bonus_to_the_manager_pay_amount() {
        Employee manager = new Manager(1000, 100);
        assertThat(manager.payAmount()).isEqualTo(1100);
    }
}
