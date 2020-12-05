package org.mooredom;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InputRecordTest {
    @Mock MinMaxCriteria mockMinMaxCriteria = Mockito.mock(MinMaxCriteria.class);

    @Test
    void testValidMinMaxInputRecord () {
        String inputString = "1-3 a: abcdadh";

        Mockito.when(mockMinMaxCriteria.getMinCount()).thenReturn(1);
        Mockito.when(mockMinMaxCriteria.getMaxCount()).thenReturn(3);
        Mockito.when(mockMinMaxCriteria.getMatchString()).thenReturn("a");
        InputRecord<MinMaxCriteria> record = new InputRecord<>(inputString, mockMinMaxCriteria);
        assertEquals(1, record.getCriteria().getMinCount());
        assertEquals(3, record.getCriteria().getMaxCount());
        assertEquals("a", record.getCriteria().getMatchString());
        assertEquals("abcdadh", record.getPassword());
    }
    
//    @Test
//    void testMatches() {
//        assertTrue(InputRecord.of("1-3 a: abcde").matchesCriteria());
//        assertTrue(InputRecord.of("2-9 c: ccccccccc").matchesCriteria());
//        assertFalse(InputRecord.of("1-3 b: cdefg").matchesCriteria());
//    }
}
