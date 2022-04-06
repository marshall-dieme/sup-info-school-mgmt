package com.supinfo.formation.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.supinfo.formation.controller.CustomUtils;
import com.supinfo.formation.controller.ModuleController;
import com.supinfo.formation.dto.ModuleDto;
import com.supinfo.formation.mapper.EntityMapper;
import com.supinfo.formation.mapper.ModuleMapper;
import com.supinfo.formation.model.Module;
import com.supinfo.formation.service.ModuleService;
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
public class ModuleControllerTest {
    private static final String ENDPOINT_URL = "/api/module";
    @InjectMocks
    private ModuleController moduleController;
    @Mock
    private ModuleService moduleService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(moduleController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<ModuleDto> page = new PageImpl<>(Collections.singletonList(ModuleBuilder.getDto()));

        Mockito.when(moduleService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(moduleService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(moduleService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(moduleService.findById(ArgumentMatchers.anyLong())).thenReturn(ModuleBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(moduleService, Mockito.times(1)).findById(1);
        Mockito.verifyNoMoreInteractions(moduleService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(moduleService.save(ArgumentMatchers.any(ModuleDto.class))).thenReturn(ModuleBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(ModuleBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(moduleService, Mockito.times(1)).save(ArgumentMatchers.any(ModuleDto.class));
        Mockito.verifyNoMoreInteractions(moduleService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(moduleService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(ModuleBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(ModuleBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(moduleService, Mockito.times(1)).update(ArgumentMatchers.any(ModuleDto.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(moduleService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(moduleService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(ModuleBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(moduleService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(moduleService);
    }
}