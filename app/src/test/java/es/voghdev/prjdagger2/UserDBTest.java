/*
 * Copyright (C) 2015 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.voghdev.prjdagger2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.voghdev.prjdagger2.datasource.db.UserDBEntry;
import es.voghdev.prjdagger2.global.model.User;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserDBTest extends BaseUnitTest {
    @Mock
    User mockUser;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldMapDBUsers() throws Exception {
        givenAMockedUser();
        UserDBEntry dbEntry = new UserDBEntry(mockUser); // Convert to DB
        User user = dbEntry.parseUser();                 // Then back to original model

        assertEquals("9875-001", user.getId());
        assertEquals("john123", user.getUsername());
        assertEquals("123 Elm St.", user.getAddress());
        assertEquals("john.doe@gmail.com", user.getEmail());
        assertEquals("765746843", user.getFacebookId());
        assertEquals(SAMPLE_AVATAR, user.getThumbnail());
        assertEquals("John Doe", user.getName());
    }

    protected void givenAMockedUser() {
        when(mockUser.getId()).thenReturn("9875-001");
        when(mockUser.getUsername()).thenReturn("john123");
        when(mockUser.getAddress()).thenReturn("123 Elm St.");
        when(mockUser.getEmail()).thenReturn("john.doe@gmail.com");
        when(mockUser.getFacebookId()).thenReturn("765746843");
        when(mockUser.getThumbnail()).thenReturn(SAMPLE_AVATAR);
        when(mockUser.getName()).thenReturn("John Doe");
    }

}
