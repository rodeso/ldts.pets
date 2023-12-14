package com.l13gr03.pets.model.CPU;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import com.l13gr03.pets.model.game.entities.Entity;

public class CPUTest {
    @Test
    public void TestEasyCPU(){
        Random mockRandom = mock(Random.class);

        when(mockRandom.nextInt(4)).thenReturn(2);

        // Criação da instância de EasyCPU passando o mock de Random
        CPUTest easyCPU = new CPUTest(mockRandom);

        // Chamada do método choseAttack
        int result = easyCPU.choseAttack(new Entity.Attack[4], new Entity(), new Entity());

        // Verificação se o método nextInt foi chamado corretamente
        // e se o resultado do método escolhido é o esperado (2)
        assertEquals(2, result);
    }
}
    }
}
