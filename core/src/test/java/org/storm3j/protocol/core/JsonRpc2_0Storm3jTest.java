/*
 * Copyright 2019 Web3 Labs LTD.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.storm3j.protocol.core;

import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;

import org.junit.Test;

import org.storm3j.protocol.storm3j;
import org.storm3j.protocol.storm3jService;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class JsonRpc2_0storm3jTest {

    private ScheduledExecutorService scheduledExecutorService =
            mock(ScheduledExecutorService.class);
    private storm3jService service = mock(storm3jService.class);

    private storm3j storm3j = storm3j.build(service, 10, scheduledExecutorService);

    @Test
    public void testStopExecutorOnShutdown() throws Exception {
        storm3j.shutdown();

        verify(scheduledExecutorService).shutdown();
        verify(service).close();
    }

    @Test(expected = RuntimeException.class)
    public void testExceptionOnServiceClosure() throws Exception {
        doThrow(new IOException("Failed to close")).when(service).close();

        storm3j.shutdown();
    }
}