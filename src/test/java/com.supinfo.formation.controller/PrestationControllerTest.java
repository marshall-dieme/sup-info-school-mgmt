package com.supinfo.formation.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.supinfo.formation.controller.CustomUtils;
import com.supinfo.formation.controller.PrestationController;
import com.supinfo.formation.dto.PrestationDto;
import com.supinfo.formation.mapper.EntityMapper;
import com.supinfo.formation.mapper.PrestationMapper;
import com.supinfo.formation.model.Prestation;
import com.supinfo.formation.service.PrestationService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;

@Transactional
public class PrestationControllerTest {
    private static final String ENDPOINT_URL = "/api/prestation";
    @InjectMocks
    private PrestationController prestationController;
    @Mock
    private PrestationService prestationService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(prestationController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<PrestationDto> page = new PageImpl<>(Collections.singletonList(PrestationBuilder.getDto()));

        Mockito.when(prestationService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(prestationService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(prestationService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(prestationService.findById(ArgumentMatchers.anyLong())).thenReturn(PrestationBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(prestationService, Mockito.times(1)).findById(1);
        Mockito.verifyNoMoreInteractions(prestationService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(prestationService.save(ArgumentMatchers.any(PrestationDto.class))).thenReturn(PrestationBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(PrestationBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(prestationService, Mockito.times(1)).save(ArgumentMatchers.any(PrestationDto.class));
        Mockito.verifyNoMoreInteractions(prestationService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(prestationService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(PrestationBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(PrestationBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(prestationService, Mockito.times(1)).update(ArgumentMatchers.any(PrestationDto.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(prestationService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(prestationService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(PrestationBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(prestationService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(prestationService);
    }
}