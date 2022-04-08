package com.supinfo.formation.controller;

import com.supinfo.formation.dto.FicheFormationDto;
import com.supinfo.formation.service.FicheFormationService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Transactional
public class FicheFormationControllerTest {
    private static final String ENDPOINT_URL = "/api/fiche-formation";
    @InjectMocks
    private FicheFormationController ficheformationController;
    @Mock
    private FicheFormationService ficheformationService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(ficheformationController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<FicheFormationDto> page = new PageImpl<>(Collections.singletonList(FicheFormationBuilder.getDto()));

        Mockito.when(ficheformationService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(ficheformationService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(ficheformationService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(ficheformationService.findById(ArgumentMatchers.anyString())).thenReturn(FicheFormationBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(ficheformationService, Mockito.times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(ficheformationService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(ficheformationService.save(ArgumentMatchers.any(FicheFormationDto.class))).thenReturn(FicheFormationBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(FicheFormationBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(ficheformationService, Mockito.times(1)).save(ArgumentMatchers.any(FicheFormationDto.class));
        Mockito.verifyNoMoreInteractions(ficheformationService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(ficheformationService.update(ArgumentMatchers.any(), ArgumentMatchers.anyString())).thenReturn(FicheFormationBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(FicheFormationBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(ficheformationService, Mockito.times(1)).update(ArgumentMatchers.any(FicheFormationDto.class), ArgumentMatchers.anyString());
        Mockito.verifyNoMoreInteractions(ficheformationService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(ficheformationService).deleteById(ArgumentMatchers.anyString());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(FicheFormationBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(ficheformationService, Mockito.times(1)).deleteById(Mockito.anyString());
        Mockito.verifyNoMoreInteractions(ficheformationService);
    }
}