package com.accolite.msproject;

import com.accolite.msproject.model.Grad;
import com.accolite.msproject.model.Institute;
import com.accolite.msproject.model.Location;
import com.accolite.msproject.model.Skill;
import com.accolite.msproject.repo.GradRepo;
import com.accolite.msproject.repo.InstituteRepo;
import com.accolite.msproject.repo.LocationRepo;
import com.accolite.msproject.repo.SkillRepo;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@TestConfiguration
public class TestConfig {

    @Bean
    public GradRepo gradRepo(){
     return new GradRepo() {
         @Override
         public Optional<Grad> findGradById(Integer id) {
             return Optional.empty();
         }

         @Override
         public List<String> getYearLabels() {
             return null;
         }

         @Override
         public List<Grad> findAll() {
             return null;
         }

         @Override
         public List<Grad> findAll(Sort sort) {
             return null;
         }

         @Override
         public List<Grad> findAllById(Iterable<Integer> iterable) {
             return null;
         }

         @Override
         public <S extends Grad> List<S> saveAll(Iterable<S> iterable) {
             return null;
         }

         @Override
         public void flush() {

         }

         @Override
         public <S extends Grad> S saveAndFlush(S s) {
             return null;
         }

         @Override
         public void deleteInBatch(Iterable<Grad> iterable) {

         }

         @Override
         public void deleteAllInBatch() {

         }

         @Override
         public Grad getOne(Integer integer) {
             return null;
         }

         @Override
         public <S extends Grad> List<S> findAll(Example<S> example) {
             return null;
         }

         @Override
         public <S extends Grad> List<S> findAll(Example<S> example, Sort sort) {
             return null;
         }

         @Override
         public Page<Grad> findAll(Pageable pageable) {
             return null;
         }

         @Override
         public <S extends Grad> S save(S s) {
             return null;
         }

         @Override
         public Optional<Grad> findById(Integer integer) {
             return Optional.empty();
         }

         @Override
         public boolean existsById(Integer integer) {
             return false;
         }

         @Override
         public long count() {
             return 0;
         }

         @Override
         public void deleteById(Integer integer) {

         }

         @Override
         public void delete(Grad grad) {

         }

         @Override
         public void deleteAll(Iterable<? extends Grad> iterable) {

         }

         @Override
         public void deleteAll() {

         }

         @Override
         public <S extends Grad> Optional<S> findOne(Example<S> example) {
             return Optional.empty();
         }

         @Override
         public <S extends Grad> Page<S> findAll(Example<S> example, Pageable pageable) {
             return null;
         }

         @Override
         public <S extends Grad> long count(Example<S> example) {
             return 0;
         }

         @Override
         public <S extends Grad> boolean exists(Example<S> example) {
             return false;
         }
     };
    }
    @Bean
    public InstituteRepo instituteRepo(){
      return new InstituteRepo() {
          @Override
          public List<String> getLabels() {
              return null;
          }

          @Override
          public List<Institute> findAll() {
              return null;
          }

          @Override
          public List<Institute> findAll(Sort sort) {
              return null;
          }

          @Override
          public List<Institute> findAllById(Iterable<Integer> iterable) {
              return null;
          }

          @Override
          public <S extends Institute> List<S> saveAll(Iterable<S> iterable) {
              return null;
          }

          @Override
          public void flush() {

          }

          @Override
          public <S extends Institute> S saveAndFlush(S s) {
              return null;
          }

          @Override
          public void deleteInBatch(Iterable<Institute> iterable) {

          }

          @Override
          public void deleteAllInBatch() {

          }

          @Override
          public Institute getOne(Integer integer) {
              return null;
          }

          @Override
          public <S extends Institute> List<S> findAll(Example<S> example) {
              return null;
          }

          @Override
          public <S extends Institute> List<S> findAll(Example<S> example, Sort sort) {
              return null;
          }

          @Override
          public Page<Institute> findAll(Pageable pageable) {
              return null;
          }

          @Override
          public <S extends Institute> S save(S s) {
              return null;
          }

          @Override
          public Optional<Institute> findById(Integer integer) {
              return Optional.empty();
          }

          @Override
          public boolean existsById(Integer integer) {
              return false;
          }

          @Override
          public long count() {
              return 0;
          }

          @Override
          public void deleteById(Integer integer) {

          }

          @Override
          public void delete(Institute institute) {

          }

          @Override
          public void deleteAll(Iterable<? extends Institute> iterable) {

          }

          @Override
          public void deleteAll() {

          }

          @Override
          public <S extends Institute> Optional<S> findOne(Example<S> example) {
              return Optional.empty();
          }

          @Override
          public <S extends Institute> Page<S> findAll(Example<S> example, Pageable pageable) {
              return null;
          }

          @Override
          public <S extends Institute> long count(Example<S> example) {
              return 0;
          }

          @Override
          public <S extends Institute> boolean exists(Example<S> example) {
              return false;
          }
      };
    }
    @Bean
    public LocationRepo locationRepo(){
       return new LocationRepo() {
           @Override
           public List<String> getLabels() {
               return null;
           }

           @Override
           public List<Location> findAll() {
               return null;
           }

           @Override
           public List<Location> findAll(Sort sort) {
               return null;
           }

           @Override
           public List<Location> findAllById(Iterable<Integer> iterable) {
               return null;
           }

           @Override
           public <S extends Location> List<S> saveAll(Iterable<S> iterable) {
               return null;
           }

           @Override
           public void flush() {

           }

           @Override
           public <S extends Location> S saveAndFlush(S s) {
               return null;
           }

           @Override
           public void deleteInBatch(Iterable<Location> iterable) {

           }

           @Override
           public void deleteAllInBatch() {

           }

           @Override
           public Location getOne(Integer integer) {
               return null;
           }

           @Override
           public <S extends Location> List<S> findAll(Example<S> example) {
               return null;
           }

           @Override
           public <S extends Location> List<S> findAll(Example<S> example, Sort sort) {
               return null;
           }

           @Override
           public Page<Location> findAll(Pageable pageable) {
               return null;
           }

           @Override
           public <S extends Location> S save(S s) {
               return null;
           }

           @Override
           public Optional<Location> findById(Integer integer) {
               return Optional.empty();
           }

           @Override
           public boolean existsById(Integer integer) {
               return false;
           }

           @Override
           public long count() {
               return 0;
           }

           @Override
           public void deleteById(Integer integer) {

           }

           @Override
           public void delete(Location location) {

           }

           @Override
           public void deleteAll(Iterable<? extends Location> iterable) {

           }

           @Override
           public void deleteAll() {

           }

           @Override
           public <S extends Location> Optional<S> findOne(Example<S> example) {
               return Optional.empty();
           }

           @Override
           public <S extends Location> Page<S> findAll(Example<S> example, Pageable pageable) {
               return null;
           }

           @Override
           public <S extends Location> long count(Example<S> example) {
               return 0;
           }

           @Override
           public <S extends Location> boolean exists(Example<S> example) {
               return false;
           }
       };
    }
    @Bean
    public SkillRepo skillRepo(){
        return new SkillRepo() {
            @Override
            public List<String> getLabels() {
                return null;
            }

            @Override
            public List<Skill> findAll() {
                return null;
            }

            @Override
            public List<Skill> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Skill> findAllById(Iterable<Integer> iterable) {
                return null;
            }

            @Override
            public <S extends Skill> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Skill> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Skill> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Skill getOne(Integer integer) {
                return null;
            }

            @Override
            public <S extends Skill> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Skill> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Skill> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Skill> S save(S s) {
                return null;
            }

            @Override
            public Optional<Skill> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(Skill skill) {

            }

            @Override
            public void deleteAll(Iterable<? extends Skill> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Skill> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Skill> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Skill> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Skill> boolean exists(Example<S> example) {
                return false;
            }
        };
    }



}
