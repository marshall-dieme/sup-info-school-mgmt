package com.supinfo.formation.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.supinfo.formation.controller.CustomUtils;
import com.supinfo.formation.controller.DetailPrestationController;
import com.supinfo.formation.dto.DetailPrestationDto;
import com.supinfo.formation.mapper.DetailPrestationMapper;
import com.supinfo.formation.mapper.EntityMapper;
import com.supinfo.formation.model.DetailPrestation;
import com.supinfo.formation.service.DetailPrestationService;
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
public class DetailPrestationControllerTest {
    private static final String ENDPOINT_URL = "/api/detail-prestation";
    @InjectMocks
    private DetailPrestationController detailprestationController;
    @Mock
    private DetailPrestationService detailprestationService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(detailprestationController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<DetailPrestationDto> page = new PageImpl<>(Collections.singletonList(DetailPrestationBuilder.getDto()));

        Mockito.when(detailprestationService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(detailprestationService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(detailprestationService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(detailprestationService.findById(ArgumentMatchers.anyLong())).thenReturn(DetailPrestationBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(detailprestationService, Mockito.times(1)).findById(1);
        Mockito.verifyNoMoreInteractions(detailprestationService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(detailprestationService.save(ArgumentMatchers.any(DetailPrestationDto.class))).thenReturn(DetailPrestationBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(DetailPrestationBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(detailprestationService, Mockito.times(1)).save(ArgumentMatchers.any(DetailPrestationDto.class));
        Mockito.verifyNoMoreInteractions(detailprestationService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(detailprestationService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(DetailPrestationBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(DetailPrestationBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(detailprestationService, Mockito.times(1)).update(ArgumentMatchers.any(DetailPrestationDto.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(detailprestationService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(detailprestationService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(DetailPrestationBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(detailprestationService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(detailprestationService);
    }
}